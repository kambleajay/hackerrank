(ns hackerrank.diagonal-difference)

(defn read-longs []
  (map #(Long/parseLong %) (-> (read-line)
                               (clojure.string/split #"\s"))))

(defn read-matrix [n]
  (take n (repeatedly read-longs)))

(defn read-diagonal-num [index-step-fn {:keys [index diagonal] :as acc} row]
  (assoc
   acc
   :index (index-step-fn index)
   :diagonal (conj diagonal (nth row index))))

(defn read-diagonal [m index index-step-fn]
  (:diagonal (reduce (partial read-diagonal-num index-step-fn) {:index index :diagonal []} m)))

(do
  (let [n (Long/parseLong (read-line))
        matrix (read-matrix n)
        primary-diagonal (read-diagonal matrix 0 inc)
        secondary-diagonal (read-diagonal matrix (dec (count matrix)) dec)]
    (print (Math/abs (- (apply + primary-diagonal) (apply + secondary-diagonal))))))
