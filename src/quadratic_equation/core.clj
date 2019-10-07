(ns quadratic-equation.core
  (:gen-class))

(defn delta
  "Calculates the discriminant of a quadratic equation"
  [a b c] (-> (Math/pow b 2) (- (* 4 a c))))
(defn x'
  "Calculates the first possible solution of a quadratic equation"
  [a b d] (-> (- b) (+ (Math/sqrt d)) (/ (* 2 a))))
(defn x''
  "Calculates the second possible solution of a quadratic equation"
  [a b d] (-> (- b) (- (Math/sqrt d)) (/ (* 2 a))))

(defn bhaskara
  "It returns the result (if any) of a quadratic expression"
  [a b c] (let [d (delta a b c)] (if (< d 0) {} (set [(x' a b d) (x'' a b d)]))))

(defn input
  "Gets an input from user just like pythonic input function"
  [msg]
  (println msg)
  (read-line))

(defn parse-int
  "Wrapper around Java's Integer.parseInt"
  [val] (Integer/parseInt val))

(defn -main
  "Entry point to application"
  [& args]
  (let [a (parse-int (input "Type the coefficient of a: "))
        b (parse-int (input "Type the coefficient of b: "))
        c (parse-int (input "Type the coefficient of c: "))
        results (bhaskara a b c)]
    (if (empty? results)
      (println "Expression cannot be solved")
      (println (str "Possible solution(s): " (reduce (fn [x y] (str x " and " y)) results))))))
