(defproject documenter "0.1.0-SNAPSHOT"
  :description "dat documenter"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/data.json "0.2.5"]
                 [clj-template "1.0.0"]
                 [org.clojure/clojure "1.6.0"]]
  :main ^:skip-aot documenter.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
