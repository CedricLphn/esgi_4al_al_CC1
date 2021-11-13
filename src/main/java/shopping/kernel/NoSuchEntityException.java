package shopping.kernel;

public final class NoSuchEntityException extends RuntimeException {

    public NoSuchEntityException(String message) { super(message); }

    public static NoSuchEntityException withId(String id) { // TODO
        return new NoSuchEntityException(String.format("No entity found with id %d", id));
    }

}
