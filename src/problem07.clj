(ns euler.problem07)

(def limit 125000)

;; Ugly but fast :)

(defn primes []
  (let [t (boolean-array limit true)]
    (doseq [i (range 2 limit)]
      (if (aget t (dec i))
        (doseq [j (range (* 2 i) (inc limit) i)]
          (aset t (dec j) false))))
    (filter #(aget ^booleans t (dec %)) (iterate inc 2))))

(defn solution []
  (println (last (take 10001 (primes)))))

(time (solution))

;; Elegant but slow :)

;(defn prime? [n]
;  (if (even? n) false
;    (empty? (filter #(zero? (rem n %)) (range 3 (inc (/ n 2)) 2)))))
;
;(defn primes [] (cons 2  (filter prime? (iterate inc 3))))
;
;(time (println (nth (primes) 10000)))


