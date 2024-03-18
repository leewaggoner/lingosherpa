package com.wreckingballsoftware.lingosherpa.data.repositories


/**
 * From: https://api.cognitive.microsofttranslator.com/languages?api-version=3.0
 *
 * TODO: Make this call to the API to get the list of languages
 */
val translationLanguageCodes = listOf(
    "af",
    "am",
    "ar",
    "as",
    "az",
    "ba",
    "bg",
    "bn",
    "bo",
    "brx",
    "bs",
    "ca",
    "cs",
    "cy",
    "da",
    "de",
    "doi",
    "dsb",
    "dv",
    "el",
    "en",
    "es",
    "et",
    "eu",
    "fa",
    "fi",
    "fil",
    "fj",
    "fo",
    "fr",
    "fr-CA",
    "ga",
    "gl",
    "gom",
    "gu",
    "ha",
    "he",
    "hi",
    "hne",
    "hr",
    "hsb",
    "ht",
    "hu",
    "hy",
    "id",
    "ig",
    "ikt",
    "is",
    "it",
    "iu",
    "iu-Latn",
    "ja",
    "ka",
    "kk",
    "km",
    "kmr",
    "kn",
    "ko",
    "ks",
    "ku",
    "ky",
    "ln",
    "lo",
    "lt",
    "lug",
    "lv",
    "lzh",
    "mai",
    "mg",
    "mi",
    "mk",
    "ml",
    "mn-Cyrl",
    "mn-Mong",
    "mni",
    "mr",
    "ms",
    "mt",
    "mww",
    "my",
    "nb",
    "ne",
    "nl",
    "nso",
    "nya",
    "or",
    "otq",
    "pa",
    "pl",
    "prs",
    "ps",
    "pt",
    "pt-PT",
    "ro",
    "ru",
    "run",
    "rw",
    "sd",
    "si",
    "sk",
    "sl",
    "sm",
    "sn",
    "so",
    "sq",
    "sr-Cyrl",
    "sr-Latn",
    "st",
    "sv",
    "sw",
    "ta",
    "te",
    "th",
    "ti",
    "tk",
    "tlh-Latn",
    "tlh-Piqd",
    "tn",
    "to",
    "tr",
    "tt",
    "ty",
    "ug",
    "uk",
    "ur",
    "uz",
    "vi",
    "xh",
    "yo",
    "yua",
    "yue",
    "zh-Hans",
    "zh-Hant",
    "zu",
)

/**
 * Looks like this:
 * {
 *     "translation": {
 *         "af": {
 *             "name": "Afrikaans",
 *             "nativeName": "Afrikaans",
 *             "dir": "ltr"
 *         },
 *         "am": {
 *             "name": "Amharic",
 *             "nativeName": "\u12a0\u121b\u122d\u129b",
 *             "dir": "ltr"
 *         },
 *         "ar": {
 *             "name": "Arabic",
 *             "nativeName": "\u0627\u0644\u0639\u0631\u0628\u064a\u0629",
 *             "dir": "rtl"
 *         },
 *         "as": {
 *             "name": "Assamese",
 *             "nativeName": "\u0985\u09b8\u09ae\u09c0\u09af\u09bc\u09be",
 *             "dir": "ltr"
 *         },
 *         "az": {
 *             "name": "Azerbaijani",
 *             "nativeName": "Az\u0259rbaycan",
 *             "dir": "ltr"
 *         },
 *         "ba": {
 *             "name": "Bashkir",
 *             "nativeName": "Bashkir",
 *             "dir": "ltr"
 *         },
 *         "bg": {
 *             "name": "Bulgarian",
 *             "nativeName": "\u0411\u044a\u043b\u0433\u0430\u0440\u0441\u043a\u0438",
 *             "dir": "ltr"
 *         },
 *         "bho": {
 *             "name": "Bhojpuri",
 *             "nativeName": "Bhojpuri",
 *             "dir": "ltr"
 *         },
 *         "bn": {
 *             "name": "Bangla",
 *             "nativeName": "\u09ac\u09be\u0982\u09b2\u09be",
 *             "dir": "ltr"
 *         },
 *         "bo": {
 *             "name": "Tibetan",
 *             "nativeName": "\u0f56\u0f7c\u0f51\u0f0b\u0f66\u0f90\u0f51\u0f0b",
 *             "dir": "ltr"
 *         },
 *         "brx": {
 *             "name": "Bodo",
 *             "nativeName": "\u092c\u0921\u093c\u094b",
 *             "dir": "ltr"
 *         },
 *         "bs": {
 *             "name": "Bosnian",
 *             "nativeName": "Bosnian",
 *             "dir": "ltr"
 *         },
 *         "ca": {
 *             "name": "Catalan",
 *             "nativeName": "Catal\u00e0",
 *             "dir": "ltr"
 *         },
 *         "cs": {
 *             "name": "Czech",
 *             "nativeName": "\u010ce\u0161tina",
 *             "dir": "ltr"
 *         },
 *         "cy": {
 *             "name": "Welsh",
 *             "nativeName": "Cymraeg",
 *             "dir": "ltr"
 *         },
 *         "da": {
 *             "name": "Danish",
 *             "nativeName": "Dansk",
 *             "dir": "ltr"
 *         },
 *         "de": {
 *             "name": "German",
 *             "nativeName": "Deutsch",
 *             "dir": "ltr"
 *         },
 *         "doi": {
 *             "name": "Dogri",
 *             "nativeName": "Dogri",
 *             "dir": "ltr"
 *         },
 *         "dsb": {
 *             "name": "Lower Sorbian",
 *             "nativeName": "Dolnoserb\u0161\u0107ina",
 *             "dir": "ltr"
 *         },
 *         "dv": {
 *             "name": "Divehi",
 *             "nativeName": "\u078b\u07a8\u0788\u07ac\u0780\u07a8\u0784\u07a6\u0790\u07b0",
 *             "dir": "rtl"
 *         },
 *         "el": {
 *             "name": "Greek",
 *             "nativeName": "\u0395\u03bb\u03bb\u03b7\u03bd\u03b9\u03ba\u03ac",
 *             "dir": "ltr"
 *         },
 *         "en": {
 *             "name": "English",
 *             "nativeName": "English",
 *             "dir": "ltr"
 *         },
 *         "es": {
 *             "name": "Spanish",
 *             "nativeName": "Espa\u00f1ol",
 *             "dir": "ltr"
 *         },
 *         "et": {
 *             "name": "Estonian",
 *             "nativeName": "Eesti",
 *             "dir": "ltr"
 *         },
 *         "eu": {
 *             "name": "Basque",
 *             "nativeName": "Euskara",
 *             "dir": "ltr"
 *         },
 *         "fa": {
 *             "name": "Persian",
 *             "nativeName": "\u0641\u0627\u0631\u0633\u06cc",
 *             "dir": "rtl"
 *         },
 *         "fi": {
 *             "name": "Finnish",
 *             "nativeName": "Suomi",
 *             "dir": "ltr"
 *         },
 *         "fil": {
 *             "name": "Filipino",
 *             "nativeName": "Filipino",
 *             "dir": "ltr"
 *         },
 *         "fj": {
 *             "name": "Fijian",
 *             "nativeName": "Na Vosa Vakaviti",
 *             "dir": "ltr"
 *         },
 *         "fo": {
 *             "name": "Faroese",
 *             "nativeName": "F\u00f8royskt",
 *             "dir": "ltr"
 *         },
 *         "fr": {
 *             "name": "French",
 *             "nativeName": "Fran\u00e7ais",
 *             "dir": "ltr"
 *         },
 *         "fr-CA": {
 *             "name": "French (Canada)",
 *             "nativeName": "Fran\u00e7ais (Canada)",
 *             "dir": "ltr"
 *         },
 *         "ga": {
 *             "name": "Irish",
 *             "nativeName": "Gaeilge",
 *             "dir": "ltr"
 *         },
 *         "gl": {
 *             "name": "Galician",
 *             "nativeName": "Galego",
 *             "dir": "ltr"
 *         },
 *         "gom": {
 *             "name": "Konkani",
 *             "nativeName": "Konkani",
 *             "dir": "ltr"
 *         },
 *         "gu": {
 *             "name": "Gujarati",
 *             "nativeName": "\u0a97\u0ac1\u0a9c\u0ab0\u0abe\u0aa4\u0ac0",
 *             "dir": "ltr"
 *         },
 *         "ha": {
 *             "name": "Hausa",
 *             "nativeName": "Hausa",
 *             "dir": "ltr"
 *         },
 *         "he": {
 *             "name": "Hebrew",
 *             "nativeName": "\u05e2\u05d1\u05e8\u05d9\u05ea",
 *             "dir": "rtl"
 *         },
 *         "hi": {
 *             "name": "Hindi",
 *             "nativeName": "\u0939\u093f\u0928\u094d\u0926\u0940",
 *             "dir": "ltr"
 *         },
 *         "hne": {
 *             "name": "Chhattisgarhi",
 *             "nativeName": "Chhattisgarhi",
 *             "dir": "ltr"
 *         },
 *         "hr": {
 *             "name": "Croatian",
 *             "nativeName": "Hrvatski",
 *             "dir": "ltr"
 *         },
 *         "hsb": {
 *             "name": "Upper Sorbian",
 *             "nativeName": "Hornjoserb\u0161\u0107ina",
 *             "dir": "ltr"
 *         },
 *         "ht": {
 *             "name": "Haitian Creole",
 *             "nativeName": "Haitian Creole",
 *             "dir": "ltr"
 *         },
 *         "hu": {
 *             "name": "Hungarian",
 *             "nativeName": "Magyar",
 *             "dir": "ltr"
 *         },
 *         "hy": {
 *             "name": "Armenian",
 *             "nativeName": "\u0540\u0561\u0575\u0565\u0580\u0565\u0576",
 *             "dir": "ltr"
 *         },
 *         "id": {
 *             "name": "Indonesian",
 *             "nativeName": "Indonesia",
 *             "dir": "ltr"
 *         },
 *         "ig": {
 *             "name": "Igbo",
 *             "nativeName": "\u00c1s\u1ee5\u0300s\u1ee5\u0301 \u00ccgb\u00f2",
 *             "dir": "ltr"
 *         },
 *         "ikt": {
 *             "name": "Inuinnaqtun",
 *             "nativeName": "Inuinnaqtun",
 *             "dir": "ltr"
 *         },
 *         "is": {
 *             "name": "Icelandic",
 *             "nativeName": "\u00cdslenska",
 *             "dir": "ltr"
 *         },
 *         "it": {
 *             "name": "Italian",
 *             "nativeName": "Italiano",
 *             "dir": "ltr"
 *         },
 *         "iu": {
 *             "name": "Inuktitut",
 *             "nativeName": "\u1403\u14c4\u1483\u144e\u1450\u1466",
 *             "dir": "ltr"
 *         },
 *         "iu-Latn": {
 *             "name": "Inuktitut (Latin)",
 *             "nativeName": "Inuktitut (Latin)",
 *             "dir": "ltr"
 *         },
 *         "ja": {
 *             "name": "Japanese",
 *             "nativeName": "\u65e5\u672c\u8a9e",
 *             "dir": "ltr"
 *         },
 *         "ka": {
 *             "name": "Georgian",
 *             "nativeName": "\u10e5\u10d0\u10e0\u10d7\u10e3\u10da\u10d8",
 *             "dir": "ltr"
 *         },
 *         "kk": {
 *             "name": "Kazakh",
 *             "nativeName": "\u049a\u0430\u0437\u0430\u049b \u0422\u0456\u043b\u0456",
 *             "dir": "ltr"
 *         },
 *         "km": {
 *             "name": "Khmer",
 *             "nativeName": "\u1781\u17d2\u1798\u17c2\u179a",
 *             "dir": "ltr"
 *         },
 *         "kmr": {
 *             "name": "Kurdish (Northern)",
 *             "nativeName": "Kurd\u00ee (Bakur)",
 *             "dir": "ltr"
 *         },
 *         "kn": {
 *             "name": "Kannada",
 *             "nativeName": "\u0c95\u0ca8\u0ccd\u0ca8\u0ca1",
 *             "dir": "ltr"
 *         },
 *         "ko": {
 *             "name": "Korean",
 *             "nativeName": "\ud55c\uad6d\uc5b4",
 *             "dir": "ltr"
 *         },
 *         "ks": {
 *             "name": "Kashmiri",
 *             "nativeName": "\u06a9\u0672\u0634\u064f\u0631",
 *             "dir": "rtl"
 *         },
 *         "ku": {
 *             "name": "Kurdish (Central)",
 *             "nativeName": "Kurd\u00ee (Nav\u00een)",
 *             "dir": "rtl"
 *         },
 *         "ky": {
 *             "name": "Kyrgyz",
 *             "nativeName": "\u041a\u044b\u0440\u0433\u044b\u0437\u0447\u0430",
 *             "dir": "ltr"
 *         },
 *         "ln": {
 *             "name": "Lingala",
 *             "nativeName": "Ling\u00e1la",
 *             "dir": "ltr"
 *         },
 *         "lo": {
 *             "name": "Lao",
 *             "nativeName": "\u0ea5\u0eb2\u0ea7",
 *             "dir": "ltr"
 *         },
 *         "lt": {
 *             "name": "Lithuanian",
 *             "nativeName": "Lietuvi\u0173",
 *             "dir": "ltr"
 *         },
 *         "lug": {
 *             "name": "Ganda",
 *             "nativeName": "Ganda",
 *             "dir": "ltr"
 *         },
 *         "lv": {
 *             "name": "Latvian",
 *             "nativeName": "Latvie\u0161u",
 *             "dir": "ltr"
 *         },
 *         "lzh": {
 *             "name": "Chinese (Literary)",
 *             "nativeName": "\u4e2d\u6587 (\u6587\u8a00\u6587)",
 *             "dir": "ltr"
 *         },
 *         "mai": {
 *             "name": "Maithili",
 *             "nativeName": "Maithili",
 *             "dir": "ltr"
 *         },
 *         "mg": {
 *             "name": "Malagasy",
 *             "nativeName": "Malagasy",
 *             "dir": "ltr"
 *         },
 *         "mi": {
 *             "name": "M\u0101ori",
 *             "nativeName": "Te Reo M\u0101ori",
 *             "dir": "ltr"
 *         },
 *         "mk": {
 *             "name": "Macedonian",
 *             "nativeName": "\u041c\u0430\u043a\u0435\u0434\u043e\u043d\u0441\u043a\u0438",
 *             "dir": "ltr"
 *         },
 *         "ml": {
 *             "name": "Malayalam",
 *             "nativeName": "\u0d2e\u0d32\u0d2f\u0d3e\u0d33\u0d02",
 *             "dir": "ltr"
 *         },
 *         "mn-Cyrl": {
 *             "name": "Mongolian (Cyrillic)",
 *             "nativeName": "Mongolian (Cyrillic)",
 *             "dir": "ltr"
 *         },
 *         "mn-Mong": {
 *             "name": "Mongolian (Traditional)",
 *             "nativeName": "\u182e\u1823\u1829\u182d\u1823\u182f \u182c\u1821\u182f\u1821",
 *             "dir": "ltr"
 *         },
 *         "mni": {
 *             "name": "Manipuri",
 *             "nativeName": "\uabc3\uabe9\uabc7\uabe9\uabc2\uabe3\uabdf",
 *             "dir": "ltr"
 *         },
 *         "mr": {
 *             "name": "Marathi",
 *             "nativeName": "\u092e\u0930\u093e\u0920\u0940",
 *             "dir": "ltr"
 *         },
 *         "ms": {
 *             "name": "Malay",
 *             "nativeName": "Melayu",
 *             "dir": "ltr"
 *         },
 *         "mt": {
 *             "name": "Maltese",
 *             "nativeName": "Malti",
 *             "dir": "ltr"
 *         },
 *         "mww": {
 *             "name": "Hmong Daw",
 *             "nativeName": "Hmong Daw",
 *             "dir": "ltr"
 *         },
 *         "my": {
 *             "name": "Myanmar (Burmese)",
 *             "nativeName": "\u1019\u103c\u1014\u103a\u1019\u102c",
 *             "dir": "ltr"
 *         },
 *         "nb": {
 *             "name": "Norwegian",
 *             "nativeName": "Norsk Bokm\u00e5l",
 *             "dir": "ltr"
 *         },
 *         "ne": {
 *             "name": "Nepali",
 *             "nativeName": "\u0928\u0947\u092a\u093e\u0932\u0940",
 *             "dir": "ltr"
 *         },
 *         "nl": {
 *             "name": "Dutch",
 *             "nativeName": "Nederlands",
 *             "dir": "ltr"
 *         },
 *         "nso": {
 *             "name": "Sesotho sa Leboa",
 *             "nativeName": "Sesotho sa Leboa",
 *             "dir": "ltr"
 *         },
 *         "nya": {
 *             "name": "Nyanja",
 *             "nativeName": "Nyanja",
 *             "dir": "ltr"
 *         },
 *         "or": {
 *             "name": "Odia",
 *             "nativeName": "\u0b13\u0b21\u0b3c\u0b3f\u0b06",
 *             "dir": "ltr"
 *         },
 *         "otq": {
 *             "name": "Quer\u00e9taro Otomi",
 *             "nativeName": "H\u00f1\u00e4h\u00f1u",
 *             "dir": "ltr"
 *         },
 *         "pa": {
 *             "name": "Punjabi",
 *             "nativeName": "\u0a2a\u0a70\u0a1c\u0a3e\u0a2c\u0a40",
 *             "dir": "ltr"
 *         },
 *         "pl": {
 *             "name": "Polish",
 *             "nativeName": "Polski",
 *             "dir": "ltr"
 *         },
 *         "prs": {
 *             "name": "Dari",
 *             "nativeName": "\u062f\u0631\u06cc",
 *             "dir": "rtl"
 *         },
 *         "ps": {
 *             "name": "Pashto",
 *             "nativeName": "\u067e\u069a\u062a\u0648",
 *             "dir": "rtl"
 *         },
 *         "pt": {
 *             "name": "Portuguese (Brazil)",
 *             "nativeName": "Portugu\u00eas (Brasil)",
 *             "dir": "ltr"
 *         },
 *         "pt-PT": {
 *             "name": "Portuguese (Portugal)",
 *             "nativeName": "Portugu\u00eas (Portugal)",
 *             "dir": "ltr"
 *         },
 *         "ro": {
 *             "name": "Romanian",
 *             "nativeName": "Rom\u00e2n\u0103",
 *             "dir": "ltr"
 *         },
 *         "ru": {
 *             "name": "Russian",
 *             "nativeName": "\u0420\u0443\u0441\u0441\u043a\u0438\u0439",
 *             "dir": "ltr"
 *         },
 *         "run": {
 *             "name": "Rundi",
 *             "nativeName": "Rundi",
 *             "dir": "ltr"
 *         },
 *         "rw": {
 *             "name": "Kinyarwanda",
 *             "nativeName": "Kinyarwanda",
 *             "dir": "ltr"
 *         },
 *         "sd": {
 *             "name": "Sindhi",
 *             "nativeName": "\u0633\u0646\u068c\u064a",
 *             "dir": "rtl"
 *         },
 *         "si": {
 *             "name": "Sinhala",
 *             "nativeName": "\u0dc3\u0dd2\u0d82\u0dc4\u0dbd",
 *             "dir": "ltr"
 *         },
 *         "sk": {
 *             "name": "Slovak",
 *             "nativeName": "Sloven\u010dina",
 *             "dir": "ltr"
 *         },
 *         "sl": {
 *             "name": "Slovenian",
 *             "nativeName": "Sloven\u0161\u010dina",
 *             "dir": "ltr"
 *         },
 *         "sm": {
 *             "name": "Samoan",
 *             "nativeName": "Gagana S\u0101moa",
 *             "dir": "ltr"
 *         },
 *         "sn": {
 *             "name": "Shona",
 *             "nativeName": "chiShona",
 *             "dir": "ltr"
 *         },
 *         "so": {
 *             "name": "Somali",
 *             "nativeName": "Soomaali",
 *             "dir": "ltr"
 *         },
 *         "sq": {
 *             "name": "Albanian",
 *             "nativeName": "Shqip",
 *             "dir": "ltr"
 *         },
 *         "sr-Cyrl": {
 *             "name": "Serbian (Cyrillic)",
 *             "nativeName": "\u0421\u0440\u043f\u0441\u043a\u0438 (\u045b\u0438\u0440\u0438\u043b\u0438\u0446\u0430)",
 *             "dir": "ltr"
 *         },
 *         "sr-Latn": {
 *             "name": "Serbian (Latin)",
 *             "nativeName": "Srpski (latinica)",
 *             "dir": "ltr"
 *         },
 *         "st": {
 *             "name": "Sesotho",
 *             "nativeName": "Sesotho",
 *             "dir": "ltr"
 *         },
 *         "sv": {
 *             "name": "Swedish",
 *             "nativeName": "Svenska",
 *             "dir": "ltr"
 *         },
 *         "sw": {
 *             "name": "Swahili",
 *             "nativeName": "Kiswahili",
 *             "dir": "ltr"
 *         },
 *         "ta": {
 *             "name": "Tamil",
 *             "nativeName": "\u0ba4\u0bae\u0bbf\u0bb4\u0bcd",
 *             "dir": "ltr"
 *         },
 *         "te": {
 *             "name": "Telugu",
 *             "nativeName": "\u0c24\u0c46\u0c32\u0c41\u0c17\u0c41",
 *             "dir": "ltr"
 *         },
 *         "th": {
 *             "name": "Thai",
 *             "nativeName": "\u0e44\u0e17\u0e22",
 *             "dir": "ltr"
 *         },
 *         "ti": {
 *             "name": "Tigrinya",
 *             "nativeName": "\u1275\u130d\u122d",
 *             "dir": "ltr"
 *         },
 *         "tk": {
 *             "name": "Turkmen",
 *             "nativeName": "T\u00fcrkmen Dili",
 *             "dir": "ltr"
 *         },
 *         "tlh-Latn": {
 *             "name": "Klingon (Latin)",
 *             "nativeName": "Klingon (Latin)",
 *             "dir": "ltr"
 *         },
 *         "tlh-Piqd": {
 *             "name": "Klingon (pIqaD)",
 *             "nativeName": "Klingon (pIqaD)",
 *             "dir": "ltr"
 *         },
 *         "tn": {
 *             "name": "Setswana",
 *             "nativeName": "Setswana",
 *             "dir": "ltr"
 *         },
 *         "to": {
 *             "name": "Tongan",
 *             "nativeName": "Lea Fakatonga",
 *             "dir": "ltr"
 *         },
 *         "tr": {
 *             "name": "Turkish",
 *             "nativeName": "T\u00fcrk\u00e7e",
 *             "dir": "ltr"
 *         },
 *         "tt": {
 *             "name": "Tatar",
 *             "nativeName": "\u0422\u0430\u0442\u0430\u0440",
 *             "dir": "ltr"
 *         },
 *         "ty": {
 *             "name": "Tahitian",
 *             "nativeName": "Reo Tahiti",
 *             "dir": "ltr"
 *         },
 *         "ug": {
 *             "name": "Uyghur",
 *             "nativeName": "\u0626\u06c7\u064a\u063a\u06c7\u0631\u0686\u06d5",
 *             "dir": "rtl"
 *         },
 *         "uk": {
 *             "name": "Ukrainian",
 *             "nativeName": "\u0423\u043a\u0440\u0430\u0457\u043d\u0441\u044c\u043a\u0430",
 *             "dir": "ltr"
 *         },
 *         "ur": {
 *             "name": "Urdu",
 *             "nativeName": "\u0627\u0631\u062f\u0648",
 *             "dir": "rtl"
 *         },
 *         "uz": {
 *             "name": "Uzbek (Latin)",
 *             "nativeName": "Uzbek (Latin)",
 *             "dir": "ltr"
 *         },
 *         "vi": {
 *             "name": "Vietnamese",
 *             "nativeName": "Ti\u1ebfng Vi\u1ec7t",
 *             "dir": "ltr"
 *         },
 *         "xh": {
 *             "name": "Xhosa",
 *             "nativeName": "isiXhosa",
 *             "dir": "ltr"
 *         },
 *         "yo": {
 *             "name": "Yoruba",
 *             "nativeName": "\u00c8d\u00e8 Yor\u00f9b\u00e1",
 *             "dir": "ltr"
 *         },
 *         "yua": {
 *             "name": "Yucatec Maya",
 *             "nativeName": "Yucatec Maya",
 *             "dir": "ltr"
 *         },
 *         "yue": {
 *             "name": "Cantonese (Traditional)",
 *             "nativeName": "\u7cb5\u8a9e (\u7e41\u9ad4)",
 *             "dir": "ltr"
 *         },
 *         "zh-Hans": {
 *             "name": "Chinese Simplified",
 *             "nativeName": "\u4e2d\u6587 (\u7b80\u4f53)",
 *             "dir": "ltr"
 *         },
 *         "zh-Hant": {
 *             "name": "Chinese Traditional",
 *             "nativeName": "\u7e41\u9ad4\u4e2d\u6587 (\u7e41\u9ad4)",
 *             "dir": "ltr"
 *         },
 *         "zu": {
 *             "name": "Zulu",
 *             "nativeName": "Isi-Zulu",
 *             "dir": "ltr"
 *         }
 *     },
 *     "transliteration": {
 *         "ar": {
 *             ...
 *         },
 *         ...
 *     },
 *     "dictionary": {
 *         "af": {
 *             ...
 *         },
 *         ...
 *     }
 * }
 */