package tech.intellispacesframework.commons.action;

import tech.intellispacesframework.commons.function.QuadFunction;
import tech.intellispacesframework.commons.function.TriFunction;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Action builders.
 */
public interface ActionBuilders {

  static <R> SettableGetter<R> resettableGetter() {
    return new ResettableGetter<>();
  }

  static <R> SettableGetter<R> resettableGetter(R initValue) {
    return new ResettableGetter<>(initValue);
  }

  /**
   * Builds getter action on base given supplier.
   *
   * @param supplier value supplier
   * @param <R> getter result value type.
   * @return getter action.
   */
  static <R> Getter<R> cachedLazyGetter(Supplier<R> supplier) {
    return new CachedLazyGetter<>(supplier);
  }

  /**
   * Builds getter action on base given value and calculating function.
   *
   * @param function calculating function.
   * @param arg function argument.
   * @param <R> getter result value type.
   * @param <T> type of the function argument.
   * @return getter action.
   */
  static <R, T> Getter<R> cachedLazyGetter(Function<T, R> function, T arg) {
    return cachedLazyGetter(() -> function.apply(arg));
  }

  /**
   * Builds getter action on base given two values and calculating function.
   *
   * @param function calculating function.
   * @param arg1 first function argument.
   * @param arg2 second function argument.
   * @param <R> getter result value type.
   * @param <T1> type of the first function argument.
   * @param <T2> type of the second function argument.
   * @return getter action.
   */
  static <R, T1, T2> Getter<R> cachedLazyGetter(BiFunction<T1, T2, R> function, T1 arg1, T2 arg2) {
    return cachedLazyGetter(() -> function.apply(arg1, arg2));
  }

  /**
   * Builds getter action on base given three values and calculating function.
   *
   * @param function calculating function.
   * @param arg1 first function argument.
   * @param arg2 second function argument.
   * @param arg3 third function argument.
   * @param <R> getter result value type.
   * @param <T1> type of the first function argument.
   * @param <T2> type of the second function argument.
   * @param <T3> type of the third function argument.
   * @return getter action.
   */
  static <R, T1, T2, T3> Getter<R> cachedLazyGetter(TriFunction<T1, T2, T3, R> function, T1 arg1, T2 arg2, T3 arg3) {
    return cachedLazyGetter(() -> function.apply(arg1, arg2, arg3));
  }

  /**
   * Builds getter action on base given four values and calculating function.
   *
   * @param function calculating function.
   * @param arg1 first function argument.
   * @param arg2 second function argument.
   * @param arg3 third function argument.
   * @param arg4 fourth source value.
   * @param <R> getter result value type.
   * @param <T1> type of the first function argument.
   * @param <T2> type of the second function argument.
   * @param <T3> type of the third function argument.
   * @param <T4> type of the fourth function argument.
   * @return getter action.
   */
  static <R, T1, T2, T3, T4> Getter<R> cachedLazyGetter(QuadFunction<T1, T2, T3, T4, R> function, T1 arg1, T2 arg2, T3 arg3, T4 arg4) {
    return cachedLazyGetter(() -> function.apply(arg1, arg2, arg3, arg4));
  }
}
