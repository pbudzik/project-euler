(defproject euler "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[io.netty/netty "3.7.0.Final"]
                 [org.clojure/clojure "1.5.1"]
                 [org.clojure/core.async "0.1.242.0-44b1e3-alpha"]
                 [criterium "0.4.2"]]
  :min-lein-version "2.0.0"
  :source-paths ["src/clojure"]
  :java-source-paths ["src/java"]
  :main legion.core
  :profiles {:uberjar {:main legion.core, :aot :all}
             :dev {:dependencies [[midje "1.6.0"]]}}

  :plugins [[lein-ancient "0.5.4"]
            [lein-kibit "0.0.8"]
            [lein-midje "3.1.1"]])
