package ssvv.noIdea.Validator;
import ssvv.noIdea.Exceptions.ValidatorException;
public interface IValidator<E> {
    void validate(E entity) throws ValidatorException;
}