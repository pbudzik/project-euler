(ns euler.problem37)

(def limit 900000)

(def primes-table
  (let [t (boolean-array limit true)]
    (aset t 0 false)
    (doseq [i (range 1 (inc limit))]
      (if (aget t (dec i))
        (doseq [j (range (* 2 i) (inc limit) i)]
          (aset t (dec j) false)))) t))

(defn- prime? [n] (aget ^booleans primes-table (dec n)))

(defn- truncatable-from? [direction n]
  (let [v (into [] (str n))
        subvectors (condp = direction
                     :left (for [i (range 0 (count v))]
                             (subvec v i (+ i (- (count v) i))))
                     :right (for [i (range 0 (count v))]
                              (subvec v 0 (- (count v) i)))
                     nil)]
    (every? prime? (map #(Integer/valueOf (clojure.string/join %)) subvectors))))

(defn truncatable? [n] (and (truncatable-from? :left n) (truncatable-from? :right n)))

(defn solution []
  (println (reduce + (take 11 (filter truncatable? (range 8 limit))))))

(time (solution))





