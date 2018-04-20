(ns v4.db
  (:require [reagent.core :as r]))

;(def titles
;  (r/atom
;    [{:title "milk"     :id (random-uuid)}
;     {:title "beer"     :id (random-uuid)}
;     {:title  "gas"     :id (random-uuid)}
;     {:title  "charger" :id (random-uuid)}
;     {:title  "chair"   :id (random-)}))

(def input (r/atom {}))
(def input-check (r/atom nil))

(def goal
  ["show how re-frame with network"
   "test 1: add some api"])

