(ns main.main-frame
  (:require
    [main.routes :as routes]))

(def version [1 2 3 4])

(defn page-view [{:keys [header content]}]
  [:div.page-wrapper
   [:header
    [:a.logo {:href (routes/home)} "home"]
    [:h1 "version : "]
    (for [v version]
      [:a.logo {:href  (routes/v {:version v})
                :key   v}
       v])]
   [:h1 header]
   [:main content]])
