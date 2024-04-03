package invoice.core.entities;

public interface IFilter<T> {
    T execute(T message);
}
