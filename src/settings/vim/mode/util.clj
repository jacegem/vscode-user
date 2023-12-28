(ns settings.vim.mode.util)

(defn convert-key [list]
  (map (fn [k]
         (let [s (name k)]
           (if (> (count s) 1)
             (str "<" s ">")
             s))) list))


(defn convert-after [list]
  (map (fn [[k v]]
         {:before (-> (if (vector? k)
                        k
                        [k])
                      convert-key)
          :after (-> (if (vector? v)
                       v
                       [v])
                     convert-key)}) list))

(defn convert-commands [list]
  (map (fn [[k v]]
         {:before (-> (if (vector? k)
                        k
                        [k])
                      convert-key)
          :commands (if (vector? v)
                      v
                      [v])}) list))

(comment
  (convert-key [:s-s])
  :rcf)
