(ns dev.user
  (:require [shadow.cljs.devtools.api :as dapi]))

(defn cljs-repl []
  (dapi/nrepl-select :browser))

(comment
  (cljs-repl)
  (in-ns 'test-ns)
  ;(ns 'test-ns)
  (+ 1 2)
  (filter even? (take 1e3 (drop 1e3 (range))))
  - > >
  (->> (range)
       (drop 1e3)
       (take 1e3)
       (filter even?)
       (map inc))

  (macroexpand-1 '(->> (drop 2 (range))))

  (set! *print-length* 10)
  *ns*
  (cljs-repl))


(def hmap {:a :b})
hmap
(assoc hmap :k :v)

(def aa (atom 1))
aa
(deref aa)
@aa
(reset! aa 2)