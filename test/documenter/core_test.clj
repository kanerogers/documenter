(ns documenter.core-test
  (:require [clojure.test :refer :all]
            [documenter.core :refer :all]))

(deftest list-files
  (testing "List all files in current directory"
    (is (= 2 (count (listFiles "testDirectory"))))))

(def testFile
  (clojure.java.io/file "testDirectory/test.json"))

(def jsonContent
  {:aww "yes"})

(deftest parse-file
  (testing "Parse a JSON file"
    (is (= jsonContent (parseFile testFile)))))

(def json
  {:method "POST",
   :url "/test/URL",
   :requestHeaders {:some "header", :other "header"},
   :description "I think so",
   :requestBody "COME ON YES SAY YEAH",
   :responseCode 200,
   :responseBody "okay yeah alright"})

(def html
    "<html><body><h1>POST /test/URL</h1> <h2>Description</h2> <p>I think so</p> <h2>Example Request</h2> <h3>Headers</h3> <code>other: header\nsome: header</code> <h3>Body</h3> <code>COME ON YES SAY YEAH</code> <h2>Example Response</h2> <h3>Response Code</h3> <code>200</code> <h3>Response Body</h3> <code>okay yeah alright</code></body></html>")

(deftest generate-html
  (testing "Generating some HTML"
    (is (= html (generateHTML json)))))

(def header
  [:name "value"])


(def parsedHeader
  "name: value")

(deftest parse-header
  (testing "Parsing Header"
    (is (= parsedHeader (parseHeader header)))))
