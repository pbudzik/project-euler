(ns euler.problem10)

(defn- sum-of-primes [n]
  (let [t (boolean-array n true)]
    (aset t 0 false)
    (doseq [i (range 1 (inc n))]
      (if (aget t (dec i))
        (doseq [j (range (* 2 i) (inc n) i)]
          (aset t (dec j) false))))
    (loop [sum 0 i 0]
      (if (< i n)
        (if (aget t i)
          (recur (+ sum (inc i)) (inc i))
          (recur sum (inc i)))
        sum))))

(defn solution []
  (println (sum-of-primes 2000000)))

(time (solution))

