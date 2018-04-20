(ns main.views
  (:require
    [main.routes :as routes]
    [main.subs :as subs]
    [main.home :as home]
    [main.main-frame :as frame]
    [re-frame.core :as re-frame]
    [reagent.core :as  r]
    [v1.view :as v1]
    [v2.view :as v2]
    [v3.view :as v3]
    [v4.view :as v4]))

(defn test-str []
  "test-a")

(defonce a (r/atom "a"))

(defn about []
 (fn []
   (let [aa @a]
     [frame/page-view
      {:content "about paging"
       :header  (str "header"
            ;       (.now js/Date)
                   (test-str)
                   "\n"
                   aa)}])))

;(defn home []
  ;[frame/page-view
  ;  {:content [:a {:href (routes/about)} (str "Learn More about shadow")]})))

(defn app-view [{:keys [page-id version]}]
  (let [page (if (= "v" page-id)
                 (str page-id version)
                 page-id)]
    (case page
      :home  [home/home]
      :about [about]
      :v1    [v1/main]
      :v2    [v2/main]
      :v3    [v3/main]
      :v4    [v4/main]
      [home/home])))

(defn app-root []
  (app-view {:page-id @(re-frame/subscribe [::subs/app-view])
             :version @(re-frame/subscribe [::subs/version])}))
