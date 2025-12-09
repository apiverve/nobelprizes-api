using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.NobelPrizes
{
    /// <summary>
    /// Query options for the Nobel Prizes API
    /// </summary>
    public class NobelPrizesQueryOptions
    {
        /// <summary>
        /// The first name of the Nobel Prize winner to get information about
        /// Example: Albert
        /// </summary>
        [JsonProperty("firstname")]
        public string Firstname { get; set; }

        /// <summary>
        /// The last name of the Nobel Prize winner to get information about
        /// Example: Einstein
        /// </summary>
        [JsonProperty("lastname")]
        public string Lastname { get; set; }

        /// <summary>
        /// The category of the Nobel Prize to get information about (e.g., Physics, Chemistry, Medicine, Peace, etc)
        /// Example: Physics
        /// </summary>
        [JsonProperty("category")]
        public string Category { get; set; }

        /// <summary>
        /// The year of the Nobel Prize to get information about (e.g., 1921)
        /// Example: 1921
        /// </summary>
        [JsonProperty("year")]
        public string Year { get; set; }
    }
}
