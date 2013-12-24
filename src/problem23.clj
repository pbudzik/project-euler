(ns euler.problem23
  (:require [clojure.set :as set]))

(defn sum-divisors [n]
  (let [limit (Math/sqrt n)]
    (loop [i 2
           sum 1]
      (cond
        (= i limit) (+ i sum)
        (> i limit) sum
        (zero? (rem n i)) (recur (inc i) (+ sum i (/ n i)))
        true (recur (inc i) sum)))))

(defn abundant? [n]
  (> (sum-divisors n) n))

(defn- all-sums []
  (let [abundants (filter abundant? (range 11 28123))]
    (distinct (for [x abundants y abundants
                    :while (and (<= y x) (<= (+ x y) 28123))] (+ x y)))))

(defn solution []
  (let [sums (all-sums)
        allnums (into #{} (range 1 28123))]
    (reduce + (set/difference allnums sums))))

;4179871

(solution)
