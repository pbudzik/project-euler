(ns euler.problem07)

(def limit 200000)

(def primes-table
  (let [t (boolean-array limit true)]
    (aset t 0 false)
    (doseq [i (range 1 (inc limit))]
      (if (aget t (dec i))
        (doseq [j (range (* 2 i) (inc limit) i)]
          (aset t (dec j) false)))) t))

(defn primes
  ([] (primes 1))
  ([n] (if (aget primes-table (dec n))
         (cons n (lazy-seq (primes (inc n))))
         (lazy-seq (primes (inc n))))))

(defn solution []
  (println (last (take 10001 (primes)))))

(solution)




