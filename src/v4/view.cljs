(ns v4.view
  (:require
    [re-frame.core :as f]
    [main.main-frame :as frame]
    ;[v3.db :as db]
    [main.subs :as main-sub]
    [main.events :as main-event]
    [v4.event :as event]
    [v4.db :as db]
    [v4.sub :as sub]
    [util.core :as util]))

(defn title [m]
  [:li {:style {:color "green"
                :padding "10px"
                :padding-left "20px"
                :list-style-type "decimal"}}
   [:span {:style {:min-width "300px"}}
          (:title m)]
   [:button {:on-click #(f/dispatch [::event/delete (:id m)])}
            "X"]])
(defn user []
 (fn []
  (let [active-user @(f/subscribe [::main-sub/active-user])]
   [:div.user-row
     [:span " user :"
      (for [[user-name key] (util/+index @(f/subscribe [::main-sub/users]))]
        ;(do
        ;  ;(println "active : " active-user user-name)
          [:span.user {:key key
                       :on-click #(f/dispatch [::main-event/user user-name])
                       :class (when (= active-user user-name)
                                    ["active"])}
                      user-name])]])))

(defn main []
  [frame/page-view
   {:header "v1 + ratom"
    :goal db/goal
    :content
      [:div
       [user]
       [:div.app
         [:button {:on-click #(f/dispatch [::event/http-get-user])}
            "get user"]
         (let [main-user (get-in @(f/subscribe [::sub/main-user])
                                 [:results 0])]
            [:div
             [:div "name : " (get-in main-user [:name :first])]
             [:div "phone : " (get-in main-user [:phone])]
             [:img {:src (get-in main-user [:picture :large])}]])]]}])
