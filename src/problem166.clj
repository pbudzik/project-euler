(ns euler.problem166
  (:import [java.util.concurrent.atomic AtomicInteger])
  (:require [clojure.core.reducers :as r]
            [clojure.core.async :as async :refer [<! >! <!! >!! timeout chan alts!! go timeout]]))

;; WIP !

(set! *warn-on-reflection* true)

(defn- sum-of-row0 [m] (reduce + (first m)))

(defn- valid-rows? [m s]
  (every? (partial = s) (map (partial reduce +) (rest m))))

(defn- valid-cols? [m s]
  (every? (partial = s)
    (map (partial reduce +) (for [i (range 4)]
                              (for [j (range 4)]
                                (nth (nth m j) i))))))

(defn- valid-diagonals? [m s]
  (and (= s (+ (nth (nth m 0) 0)
              (nth (nth m 1) 1)
              (nth (nth m 2) 2)
              (nth (nth m 3) 3)))
    (= s (+ (nth (nth m 0) 3)
           (nth (nth m 1) 2)
           (nth (nth m 2) 1)
           (nth (nth m 3) 0)))))

(def C (atom 0))

(defn- valid? [m]
  (swap! C inc)
  (println @C)
  (let [s (sum-of-row0 m)]
    (and (valid-diagonals? m s)
      (valid-rows? m s)
      (valid-cols? m s))))

(defn solution []
  (let [rows (for [a (range 10) b (range 10) c (range 10) d (range 10)] [a b c d])]
    ;(println (count (into [] (r/filter valid? (for [r0 rows r1 rows r2 rows r3 rows] [r0 r1 r2 r3])))))
    (doseq [r0 rows r1 rows r2 rows r3 rows]
      (println [r3 r2 r1 r0])
      ))
  )

(def m [[6 3 3 0] [5 0 4 3] [0 7 1 4] [1 2 4 5]])
(def y [[6 3 3 1] [5 0 4 3] [0 7 1 4] [1 2 4 5]])

;;--

;(every? (partial = 12) (reduce + (rest m)))

;(time (valid-rows? m 12))

;(count (c/selections [0 1 2 3 4 5 6 7 8 9] 4))

;(solution)

(time (valid? y))

(time (valid? m))

;(selections)

