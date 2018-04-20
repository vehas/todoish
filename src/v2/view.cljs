(ns v2.view
  (:require
    [main.main-frame :as frame]
    [v2.db :as db]
    [v2.event :as event]))

(defn title [m]
  ;(println "title")
  [:li {:style {:color "green"
                :padding "10px"
                :padding-left "20px"
                :list-style-type "decimal"}}
   (:title m)])

(defn main []
  [frame/page-view
   {:header "v1 + ratom"
    :content
            [:div
             [:form
              [:label "add list"]
              [:input {:type        "text"
                       :value       (:text @db/input)
                       :placeholder @db/input-check
                       :on-change   #(swap! db/input assoc :text (-> % .-target .-value))}]
              [:button {:on-click (fn [e]
                                    (.preventDefault e)
                                    (event/save-text))}
               "add"]]
             [:ul
              (for [t @db/titles]
                [title (assoc t :key (:id t))])]]}])
