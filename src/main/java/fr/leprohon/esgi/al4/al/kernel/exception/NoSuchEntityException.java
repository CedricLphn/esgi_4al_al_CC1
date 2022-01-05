package fr.leprohon.esgi.al4.al.kernel.exception;

public final class NoSuchEntityException extends RuntimeException {

    public NoSuchEntityException(String message) { super(message); }

    public static NoSuchEntityException withId(int id) {
        return new NoSuchEntityException(String.format("No entity found with id %d", id));
    }

}
