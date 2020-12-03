(ns hackerrank.time-conversion)

(defrecord Time [hour minutes seconds period])

(defn parse-time [s]
  (let [parts (clojure.string/split s #":")
        seconds-and-period (last parts)
        seconds (clojure.string/join (take 2 seconds-and-period))
        period (clojure.string/join (take-last 2 seconds-and-period))]
    (->Time (Long/parseLong (first parts))
            (Long/parseLong (nth parts 1))
            (Long/parseLong seconds)
            period)))

(defn period= [period v]
  (= (clojure.string/lower-case period) v))

(defn pm? [period]
  (period= period "pm"))

(defn am? [period]
  (period= period "am"))

(defn military-time [{:keys [hour period] :as t}]
  (cond
    (and (pm? period) (not= hour 12)) (update t :hour + 12)
    (and (am? period) (= hour 12)) (assoc t :hour 0)
    :else t))

(defn time-to-str [{:keys [hour minutes seconds]}]
  (format "%02d:%02d:%02d" hour minutes seconds))

(let [time-str (read-line)
      time-as-12-hr (parse-time time-str)]
  (print (-> time-as-12-hr
             military-time
             time-to-str)))
