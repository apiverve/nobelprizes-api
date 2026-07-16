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
        /// </summary>
        [JsonProperty("firstname")]
        public string Firstname { get; set; }

        /// <summary>
        /// The last name of the Nobel Prize winner to get information about
        /// </summary>
        [JsonProperty("lastname")]
        public string Lastname { get; set; }

        /// <summary>
        /// The category of the Nobel Prize to get information about
        /// </summary>
        [JsonProperty("category")]
        public string Category { get; set; }

        /// <summary>
        /// The year of the Nobel Prize to get information about
        /// </summary>
        [JsonProperty("year")]
        public int? Year { get; set; }
    }
}
