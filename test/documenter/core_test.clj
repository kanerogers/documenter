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
