package tech.intellispaces.framework.commons.function;

import tech.intellispaces.framework.commons.exception.CoveredCheckedException;

public interface RunnableFunctions {

  @SuppressWarnings("unchecked")
  static <E extends Throwable> void runAndUncoverIfCovered(Runnable runnable, Class<E> e) throws E {
    try {
      runnable.run();
    } catch (CoveredCheckedException se) {
      if (e.isInstance(se.getCause())) {
        throw (E) se.getCause();
      } else {
        throw se;
      }
    }
  }
}
