(ns hackerrank.a-very-big-sum)

(defn read-longs []
  (map #(Long/parseLong %) (-> (read-line)
                               (clojure.string/split #"\s"))))
(do
  (read-line)
  (print (apply + (read-longs))))
