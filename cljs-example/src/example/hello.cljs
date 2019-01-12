(ns example.hello
  (:require [taoensso.tufte :as tufte
             :refer-macros (defnp p profiled profile)]))

(tufte/add-basic-println-handler! {})

(defn get-x [] (+ 1 1))
(defn get-y [] (+ 2 2))

(profile ; Profile any `p` forms called during body execution
  {} ; Profiling options; we'll use the defaults for now
  (dotimes [_ 5]
    (p :get-x (get-x))
    (p :get-y (get-y))))
