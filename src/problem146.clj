(ns problem146
  (:require [clojure.core.reducers :as r]))

(def N (* 150 1000 1000))

(defn prime? [n]
  (if (or (zero? (mod n 2)) (zero? (mod n 3)))
    false
    (.isProbablePrime ^java.math.BigInteger (java.math.BigInteger/valueOf n) 5)))

(defn solution? [n]
  (let [s (* n n)]
    (when (not (or
                 (not= (mod s 3) 1)
                 (and (not= (mod s 7) 2) (not= (mod s 7) 3))
                 (or (zero? (mod s 9)) (zero? (mod s 13)) (zero? (mod s 27)))))
      (when (and
              (every? prime? [(+ s 1) (+ s 3) (+ s 7) (+ s 9) (+ s 13) (+ s 27)])
              (not (some prime? [(+ s 19) (+ s 21)])))
        n))))

(time
  (println
    (r/fold (fn ([] 0) ([x y] (+ x y)))
      (r/filter some?
        (r/map solution?
          (range 10 N 10))))))



