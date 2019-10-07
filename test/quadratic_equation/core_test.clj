(ns quadratic-equation.core-test
  (:require [clojure.test :refer :all]
            [quadratic-equation.core :refer :all]))

(deftest delta-test
  (testing "whether discriminant returns correct values"
    (is (= (delta 1 4 9) -20.0))))

(deftest bhaskara-0-test
  (testing "whether the function returns only real values"
    (is (empty? (bhaskara 5 3 5)))))

(deftest bhaskara-1-test
  (testing "whether when a discriminant is 0, it returns a single value"
    (is (= 1 (count (bhaskara 9 -12 4))))))

(deftest bhaskara-2-test
  (testing "whether x²+10x-119=0 has x'=7 and x''=-17"
    (is (= (set [7.0 -17.0]) (bhaskara 1 10 -119)))))

(deftest x'-test
  (testing "whether x²+(5/2)x-(3/2)=0 has x'=1/2"
    (is (= 0.5 (x' 1 2.5 (/ 49 4))))))

(deftest x''-test
  (testing "whether x²+(5/2)x-(3/2)=0 has x''=-3"
    (is (= -3.0 (x'' 1 2.5 (/ 49 4))))))

(deftest parse-int-test
  (testing "parsing \"23\" to int returns 23"
    (is (= 23 (parse-int "23")))))
