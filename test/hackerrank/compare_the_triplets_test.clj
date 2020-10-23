(ns hackerrank.compare-the-triplets-test
  (:require [clojure.test :refer :all]
            [hackerrank.compare-the-triplets :refer :all]))

(deftest test-compare-the-triplets
  (testing "simple example"
    (are [ratings-1 ratings-2 result] (= (scores ratings-1 ratings-2) result)
                                      [1 2 3] [3 2 1] "1 1"
                                      [5 6 7] [3 6 10] "1 1"
                                      [5 5 5] [1 1 1] "3 0"
                                      [2 2 2] [2 2 2] "0 0"
                                      [1 1 1] [2 2 2] "0 3")))

(deftest test-read-rating
  (with-in-str "1 2 3"
               (is (= (read-rating) [1 2 3]))))
