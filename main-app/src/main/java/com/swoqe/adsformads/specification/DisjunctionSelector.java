package com.swoqe.adsformads.specification;

import java.util.List;

/**
 * A Selector defined as the disjunction (OR) of other (leaf) selectors.
 */
public class DisjunctionSelector<T> extends AbstractSelector<T> {

  private final List<AbstractSelector<T>> leafComponents;

  @SafeVarargs
  DisjunctionSelector(AbstractSelector<T>... selectors) {
    this.leafComponents = List.of(selectors);
  }

  /**
   * Tests if *at least one* selector passes the test.
   */
  @Override
  public boolean test(T t) {
    return leafComponents.stream().anyMatch(comp -> comp.test(t));
  }
}