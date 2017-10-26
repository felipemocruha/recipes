(ns recipes.core
  (:require [clojure.edn :as edn])
;  (:require [clojurewerkz/neocons "3.1.0"])
  (:require [clojure.string :as string]))


;(def conn (nr/connect "http://localhost:7474/db/data/"))

(defn ingredient [lst]
  {:quant (nth lst 0)
   :unit (nth lst 1)
   :ingredients (nth lst 2)})

(defn parse-ings [data]
  (into [] (map ingredient (:ingredients data))))

(defn file-to-data [file]
  (read-string (str "{" (slurp file) "}")))

(defn -main
  [& args]
  (def data (file-to-data (first args)))
  (println (parse-ings data)))
