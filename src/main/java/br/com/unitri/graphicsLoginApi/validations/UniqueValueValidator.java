package br.com.unitri.graphicsLoginApi.validations;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {

    private String domainAtributte;
    private Class<?> klass;
    @PersistenceContext
    private EntityManager manager;

    public void initialize (UniqueValue params){
        domainAtributte = params.fieldName();
        klass = params.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        Query query = manager.createQuery("select 1 from " + klass.getName() +" where " + domainAtributte +"=:value");
        query.setParameter("value", value);
        List<?> list = query.getResultList();
        Assert.state(list.size() <= 1, "Foi encontrado pelo menos um" + klass + "com o atributo "+ domainAtributte + "= " +value);
        return list.isEmpty();
    }
}