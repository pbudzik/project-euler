(ns euler.problem36)

(defn palindrom? [s] (= (clojure.string/reverse s) s))

(defn palindromic-number? [n]
  (and (palindrom? (str n)) (palindrom? (Integer/toBinaryString n))))

(defn solution []
  (println (reduce + (filter palindromic-number? (range 1000000)))))

(time (solution))
