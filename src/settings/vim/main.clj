(ns settings.vim.main
  (:require [clojure.data.json :as json]
            [settings.vim.mode.insert :refer [vim-insert]]
            [settings.vim.mode.normal :refer [vim-normal]]
            [settings.vim.mode.visual :refer [vim-visual]]
            [malli.core :as m]))

(defn write-settings []
  (let [file-name "settings.json"
        settings (json/read-str (slurp file-name))
        config (merge settings
                      (vim-insert)
                      (vim-normal)
                      (vim-visual))

        json-str (json/write-str config {:escape-slash false
                                         :escape-unicode true})]
    (spit file-name json-str)))


(def Item
  (m/schema
   [:map
    [:title string?]
    [:link {:optional true} string?]]))



(comment
  (write-settings)
  (require '[malli.provider :as mp])
  (mp/provide [{:a 2}])

  (require '[malli.dev :as dev])
  (dev/start!)
  (dev/stop!)
  :rcf)
