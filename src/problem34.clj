(ns euler.problem34
  (:require [clojure.core.reducers :as r]))

(defn- factorial [n]
  (loop [k (int n) sum 1]
    (if (zero? k) sum
      (recur (- k 1) (* sum k)))))

(defn- curious? [n]
  (= n (r/reduce + (r/map #(factorial (read-string (str %))) (str n)))))

(def limit 200000)

(defn solution []
  (println (r/reduce + (into [] (r/filter curious? (range 3 limit))))))

(time (solution))




