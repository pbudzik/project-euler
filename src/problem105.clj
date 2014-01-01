(ns euler.problem105
  (:require [clojure.math.combinatorics :as c]
            [clojure.set :as s]
            [clojure.core.reducers :as r]))

(defn- to-int-set [v] (set (map read-string v)))

(def sets (map #(to-int-set (.split % ",")) (.split (slurp "src/sets.txt") "\n")))

(defn- sum [s] (reduce + s))

(defn- disjointed? [s]
  (let [[a b] s]
    (= (s/intersection a b) #{})))

(defn- disjointed-subsets [s]
  (filter disjointed? (pmap #(vector (set (first %)) (set (second %))) (c/combinations (rest (c/subsets s)) 2))))

(defn- special-sum-set? [s]
  (loop [pairs (disjointed-subsets s) result true]
    (let [p (first pairs)
          [a b] p
          sa (sum a)
          sb (sum b)
          result (not (or (= sa sb) (and (> (count b) (count a)) (< sb sa))))
          tail (rest pairs)]
      (if (or (not result) (empty? tail)) result
        (recur tail result)))))

(defn solution []
  (sum (pmap sum (filter special-sum-set? sets))))

(solution)




