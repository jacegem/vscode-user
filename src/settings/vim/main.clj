(ns settings.vim.main
  (:require [clojure.data.json :as json]
            [settings.vim.mode.insert :refer [vim-insert]]
            [settings.vim.mode.normal :refer [vim-normal]]))



(defn write-settings []
  (let [file-name "settings.json"
        settings (json/read-str (slurp file-name))
        config (merge settings
                      (vim-insert)
                      (vim-normal))
        json-str (json/write-str config {:escape-slash false
                                         :escape-unicode true})]
    (spit file-name json-str)))




(comment
  (write-settings)
  :rcf)
