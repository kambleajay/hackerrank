(ns hackerrank.staircase)

(let [n (Long/parseLong (read-line))]
  (doseq [c (range n)]
    (printf (str "%" n "s\n") (clojure.string/join "" (repeat (inc c) "#")))))
