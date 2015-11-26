package model.entity;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import junit.framework.Assert;
import model.entity.Param;

import org.junit.Before;
import org.junit.Test;

import util.Util;

public class ParamTest {

	private static Param param;
	private Validator validator;

	public static Param getParam() {
		Param param = new Param();
		param.setChave(Util.getStringWithSize(255));
		param.setValor(Util.getStringWithSize(255));
		param.setDescricao(Util.getStringWithSize(255));
		return param;
	}

	@Before
	public void setUp() {
		param = getParam();
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}

	@Test
	public void paramIsValid() {
		Set<ConstraintViolation<Param>> errors = validator.validate(param);
		Assert.assertEquals(0, errors.size());
	}

	@Test
	public void chaveIsNull() {
		param.setChave(null);
		Set<ConstraintViolation<Param>> errors = validator.validate(param);
		assertEquals(1, errors.size());
		assertEquals("O campo CHAVE não pode ser nulo", errors.iterator()
				.next().getMessage());
	}

	@Test
	public void chaveIsTooSmall() {
		param.setChave(Util.getStringWithSize(2));
		Set<ConstraintViolation<Param>> errors = validator.validate(param);
		assertEquals(1, errors.size());
		assertEquals("O campo CHAVE deve ter entre 3 e 255 caracteres", errors
				.iterator().next().getMessage());
	}

	@Test
	public void chaveIsTooBig() {
		param.setChave(Util.getStringWithSize(256));
		Set<ConstraintViolation<Param>> errors = validator.validate(param);
		assertEquals(1, errors.size());
		assertEquals("O campo CHAVE deve ter entre 3 e 255 caracteres", errors
				.iterator().next().getMessage());
	}

	@Test
	public void valorIsNull() {
		param.setValor(null);
		Set<ConstraintViolation<Param>> errors = validator.validate(param);
		assertEquals(1, errors.size());
		assertEquals("O campo VALOR não pode ser nulo", errors.iterator()
				.next().getMessage());
	}

	@Test
	public void valorIsTooSmall() {
		param.setValor(Util.getStringWithSize(2));
		Set<ConstraintViolation<Param>> errors = validator.validate(param);
		assertEquals(1, errors.size());
		assertEquals("O campo VALOR deve ter entre 3 e 255 caracteres", errors
				.iterator().next().getMessage());
	}

	@Test
	public void valorIsTooBig() {
		param.setValor(Util.getStringWithSize(256));
		Set<ConstraintViolation<Param>> errors = validator.validate(param);
		assertEquals(1, errors.size());
		assertEquals("O campo VALOR deve ter entre 3 e 255 caracteres", errors
				.iterator().next().getMessage());
	}

	@Test
	public void descricaoIsNull() {
		param.setDescricao(null);
		Set<ConstraintViolation<Param>> errors = validator.validate(param);
		assertEquals(1, errors.size());
		assertEquals("O campo DESCRIÇÃO não pode ser nulo", errors.iterator()
				.next().getMessage());
	}

	@Test
	public void descricaoIsTooSmall() {
		param.setDescricao(Util.getStringWithSize(2));
		Set<ConstraintViolation<Param>> errors = validator.validate(param);
		assertEquals(1, errors.size());
		assertEquals("O campo DESCRIÇÃO deve ter entre 3 e 255 caracteres",
				errors.iterator().next().getMessage());
	}

	@Test
	public void descricaoIsTooBig() {
		param.setDescricao(Util.getStringWithSize(256));
		Set<ConstraintViolation<Param>> errors = validator.validate(param);
		assertEquals(1, errors.size());
		assertEquals("O campo DESCRIÇÃO deve ter entre 3 e 255 caracteres",
				errors.iterator().next().getMessage());
	}

}
