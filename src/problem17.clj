(ns euler.problem17)

(defn- spell [n]
  (let [N1-19 ["one" "two" "three" "four" "five" "six" "seven" "eight" "nine" "ten" "eleven"
               "twelve" "thirteen" "fourteen" "fifteen" "sixteen" "seventeen" "eighteen" "nineteen"]
        N20-90 ["twenty" "thirty" "forty" "fifty" "sixty" "seventy" "eighty" "ninety"]]
    (cond
      (= n 0) ""
      (< n 20) (nth N1-19 (dec n))
      (and (< n 100) (>= n 20)) (let [k (int (/ n 10))
                                      j (- n (* k 10))]
                                  (str (nth N20-90 (- k 2)) (if (zero? (rem n 10)) "" " ") (spell j)))
      (and (< n 1000) (>= n 100)) (let [k (int (/ n 100))
                                        j (- n (* k 100))]
                                    (str (spell k) " hundred" (if (zero? (rem n 100)) "" " and ") (spell j)))
      (= n 1000) "one thousand")))

(defn- length [n] (count (.replaceAll (spell n) "\\s" "")))

(defn solution []
  (println (reduce + (map length (range 1 1001)))))

(solution)