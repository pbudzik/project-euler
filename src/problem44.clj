(ns euler.problem44)

(def upper-bound (* 1000 10000))

(defn pentagonal? [n]
  (let [x (/ (inc (java.lang.Math/sqrt (inc (* 24 n)))) 6)]
    (= x (double (int x)))))

(defn abs [n] (max n (- n)))

(defn d [[a b]]
  (when
    (pentagonal? (+ a b))
    (let [d (java.lang.Math/abs (- b a))]
      (when (pentagonal? d) d))))

(defn solution []
  (let [pentagonals (into [] (filter pentagonal? (range 1 upper-bound)))
        n (count pentagonals)
        combos (for [i (range 0 n)
                     j (range (inc i) n)]
                 [(nth pentagonals i) (nth pentagonals j)])]
    (reduce min (filter #(not (nil? %)) (map d combos)))))

(time (solution))



