(ns documenter.core
  (:refer-clojure :rename {map clj-map meta clj-meta time clj-time})
  (:require [clojure.data.json :as json]
            [clj-template.html5 :refer :all])
  (:gen-class))

(use '[clojure.string :only (join split)])

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


(defn parseHeader
  [headerData]
  (join ": " [
               (name (first headerData))
               (nth headerData 1)
               ]))

(defn generateHTML
  [jsonData]
  (html
    (body
      (h1 (:method jsonData) (:url jsonData))
      (h2 "Description")
      (p (:description jsonData))
      (h2 "Example Request")
      (h3 "Headers")
      (code 
        (join "\n" 
          (clj-map parseHeader 
            (:requestHeaders jsonData))))
      (h3 "Body")
      (code (:requestBody jsonData))
      (h2 "Example Response")
      (h3 "Response Code")
      (code (str (:responseCode jsonData)))
      (h3 "Response Body")
      (code (:responseBody jsonData)))))
      

