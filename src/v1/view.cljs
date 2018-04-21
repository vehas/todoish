(ns v1.view
  (:require
    [main.main-frame :as frame]
    [v1.db :as db]
    [util.core :as util]))

(defn title [m]
  ;(println "title")
  [:li {:style {:color "green"
                :padding "10px"
                :padding-left "20px"}}
                ;:list-style-type "decimal"}}
       (:title m)])

(defn add-index [{:keys [title] :as t} index]
  (assoc t :title (str index " " title)))

(=
  (add-index {:title "a" :key "1"} 1)
  {:title "1 a" :key "1"})

(defn main []
  [frame/page-view
   {:header "basic todo list with list of text"
    :goal db/goal
    :content [:div.nest "hi"
              [:div.nest "l1 1"
               [:div.nest "l1 2"]
               [:h1.nest "l2 1"]
               ;[title {:title "test title"}]
               [:ul
                (for [[t index] (util/+index db/titles)]
                  [title (assoc (add-index t (inc index))
                           :key index)])]]]}])
(comment
  (+ 1 2)
  (+ 4 
    (+ 2 3234234))
  (- 2 3)
  ((fn [a])
   (+ a 1)
   2)
  (println "test")
  (util.core/+index [2 2 2])
  (js/alert))
  
