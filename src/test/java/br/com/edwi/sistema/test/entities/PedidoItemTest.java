package br.com.edwi.sistema.test.entities;

import br.com.edwi.sistema.entities.PedidoItem;
import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.NoPrimitivesRule;
import com.openpojo.validation.rule.impl.NoPublicFieldsRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
import org.junit.Before;
import org.junit.Test;

public class PedidoItemTest {

    private PojoClass pedidoItemEntity;
    private Validator validator;

    @Before
    public void init() {
        this.pedidoItemEntity = PojoClassFactory.getPojoClass(PedidoItem.class);
        this.validator = ValidatorBuilder.create()
                .with(new SetterMustExistRule())
                .with(new GetterMustExistRule())
                .with(new NoPublicFieldsRule())
                .with(new NoPrimitivesRule())
                .with(new GetterTester())
                .with(new SetterTester())
                .build();

    }

    @Test
    public void validate() {
        validator.validate(this.pedidoItemEntity);
    }
}