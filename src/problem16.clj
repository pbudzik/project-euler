(ns euler.problem16
  (:import [java.math BigDecimal]))

(def value (BigDecimal. (Math/pow 2 1000)))

(defn solution []
  (println (reduce + (map #(read-string (str %)) (str value)))))

(time (solution))

