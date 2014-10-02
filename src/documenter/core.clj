(ns documenter.core
  (:require [clojure.data.json :as json])
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn listFiles
  [path]
  (file-seq (clojure.java.io/file path)))

(defn parseFile
  [file]
  (json/read-str (slurp file)
                :key-fn keyword))

