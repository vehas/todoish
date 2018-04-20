(ns test.core-test
  (:require [cljs.test :refer [deftest is testing]]))

(deftest example-test
  (is (= true true)))

(deftest test-2
  (is false))

(deftest test-3
  (is true))