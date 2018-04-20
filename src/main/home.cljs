(ns main.home
  (:require [main.main-frame :as frame]))

(def link
  [{:link "http://cljs.info/cheatsheet/"
    :title "cljs cheatsheet"
    :description "all standard cljs function in one place group by used & link to clojure doc"}
   {:link "http://clojure-doc.org/articles/tutorials/introduction.html"
    :title "intro to clojure"
    :description "good enough intro to clojure"}
   {:link "https://www.youtube.com/watch?v=P76Vbsk_3J0"
    :title "video intro to clojure for java programmer"
    :description "one of the best intro to clojure video by clojure creator"}
   {:link "https://www.4clojure.com/"
    :title "4clojure"
    :description "web for easy to hard clojure problem"}
   {:link "https://github.com/thheller/shadow-cljs"
    :title "shadow cljs"
    :description "cljs build tool"}])

(defn home []
  [frame/page-view
   {:header "reading list"
    :content
     [:div
      (for [[l key] (util.core/+index link)]
       [:a {:style {:background-color "#ccc"
                    :padding-bottom "15px"
                    :margin-top "10px"
                    :padding "10px"
                    :border-radius "5px"
                    :display "block"
                    :box-shadow  "0px 4px 4px -2px #000000"
                    :text-decoration "none"
                    :color "black"}
            :href (:link l)
            :target "_blank"
            :key key}
        [:div
         [:span
          {:style
           {:background-color "#cff"
            :margin-left "-10px"
            :margin-top "-20px"
            :margin-bottom "5px"
            :padding "10px"
            :border-top-left-radius "5px"}}
          (:title l)]]
        [:div {:style {:word-wrap "break-word"}}
         (:description l)]])]}])